import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Role, User} from '../data/user';

import {Injectable} from '@angular/core';

@Injectable()
export class RoleService {
    constructor(
        private httpClient: HttpClient,
    )  {

    }

    getRoles() {
        const urlRequest = `${environment.apiUrl}/api/roles`;
        return this.httpClient.get<Role[]>(urlRequest);
    }
}
