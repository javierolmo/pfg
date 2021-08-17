export class User {
    id: number;
    name: string;
    surname: string;
    email: string;
    enabled: boolean;
    roles: Role[];
}

export class Role {
    id: number;
    name: string;
}
