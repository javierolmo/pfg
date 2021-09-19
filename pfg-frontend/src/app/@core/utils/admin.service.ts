import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Log} from '../data/log';
import {Page} from '../data/page';
import {NbAuthJWTToken, NbAuthService} from '@nebular/auth';

@Injectable()
export class AdminService {

    token: string;

    constructor(private httpClient: HttpClient, protected authService: NbAuthService)  {
        this.authService.onTokenChange().subscribe((jwttoken: NbAuthJWTToken) => {
            this.token = jwttoken.getValue();
        });
    }

    getLogs(index: number, size: number, ascendent?: boolean)  {
        let urlRequest = `${environment.apiUrl}/api/admin/logs/page?`;
        if (index !== undefined) urlRequest += `index=${index}&`;
        if (size !== undefined) urlRequest += `size=${size}&`;
        if (ascendent !== undefined) urlRequest += `ascendent=${ascendent}&`;
        return this.httpClient.get<Page<Log>>(urlRequest, {headers: {'Authorization': this.token }});
    }

}
