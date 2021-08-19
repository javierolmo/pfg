import {Component, Input, OnInit} from '@angular/core';
import {Role, User} from '../../@core/data/user';

@Component({
  selector: 'ngx-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss'],
})
export class UserFormComponent implements OnInit {

  @Input()
  user: User;
  @Input()
  roles: Role[];

  constructor() {
  }

  ngOnInit(): void {
  }

  findRolesIds(user: User): number[] {
    return user.roles.map(role => role.id);
  }

  selectRole(role: Role) {
    const isPresent: boolean = this.user.roles.filter(r => r.id === role.id).length > 0;
    if (isPresent) {
      this.user.roles = this.user.roles.filter(r => r.id !== role.id);
    } else {
      this.user.roles.push(role);
    }
  }

}
