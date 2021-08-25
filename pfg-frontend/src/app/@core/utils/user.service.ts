import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import {NewPasswordRequest, User} from '../data/user';
import {GeneticSpecs} from '../data/geneticSpecs';
import {Sheet} from '../data/sheet';
import {NbAuthJWTToken, NbAuthService} from '@nebular/auth';
import {TokenResponse} from '../data/token';
import {Observable} from 'rxjs';

@Injectable()
export class UserService {

  token: string;

  constructor(
      private httpClient: HttpClient,
      private authService: NbAuthService,
  )  {
    this.authService.onTokenChange().subscribe((jwttoken: NbAuthJWTToken) => {
      this.token = jwttoken.getValue();
    });
  }

  getUsers() {
    const urlRequest = `${environment.apiUrl}/api/users`;
    return this.httpClient.get<User[]>(urlRequest);
  }

  put(id: number, user: User): Observable<User> {
    const urlRequest = `${environment.apiUrl}/api/users/${id}`;
    return this.httpClient.put<User>(urlRequest, user);
  }

  getUser(id:  number ) {
      const urlRequest = `${environment.apiUrl}/api/users/${id}`;
      return this.httpClient.get<User>(urlRequest);
  }

  postSheetRequest(specs: GeneticSpecs, userId: number) {
    const urlRequest = `${environment.apiUrl}/api/users/${userId}/request`;
    return this.httpClient.post<Sheet>(urlRequest, specs);
  }

  generateToken(duration: number, userId: number) {
    const urlRequest = `${environment.apiUrl}/api/users/${userId}/token`;
    const headers = new HttpHeaders().set('Authorization', this.token);
    return this.httpClient.get<TokenResponse>(urlRequest, {headers: headers});
  }

  resetPassword(userId, newPassword) {
    const newPasswordRequest = new NewPasswordRequest(newPassword);
    const urlRequest = `${environment.apiUrl}/api/users/${userId}/reset-password`;
    const headers = new HttpHeaders().set('Authorization', this.token);
    return this.httpClient.post<User>(urlRequest, newPasswordRequest, {headers: headers});
  }

}

