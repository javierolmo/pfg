export class TokenResponse {
    token: string;
}

export interface TokenPayload {
    email: string;
    authorities: string;
    exp: number;
    iat: number;
    id: number;
    jti: string;
    name: string;
    sub: string;
    surname: string;
}
