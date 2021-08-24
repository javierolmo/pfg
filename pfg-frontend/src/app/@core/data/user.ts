export class User {
    id: number;
    name: string;
    surname: string;
    email: string;
    enabled: boolean;
    roles: Role[];

    clone(): User {
        console.log('Hola')
        const result = new User();
        result.id = this.id;
        result.name = this.name;
        result.surname = this.surname;
        result.email = this.email;
        result.enabled = this.enabled;
        result.roles = this.roles;
        return result;
    }

}

export class Role {
    id: number;
    name: string;
}
