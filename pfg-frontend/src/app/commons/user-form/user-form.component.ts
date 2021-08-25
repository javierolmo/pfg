import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
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
  @Output()
  userEventEmitter = new EventEmitter<User>();
  editedUser: User;

  constructor() {
  }

  ngOnInit(): void {
    this.editedUser = new User();
    this.editedUser.id = this.user.id;
    this.editedUser.name = this.user.name;
    this.editedUser.roles = this.user.roles;
    this.editedUser.enabled = this.user.enabled;
    this.editedUser.email = this.user.email;
    this.editedUser.surname = this.user.surname;
  }

  findRolesIds(user: User): number[] {
    return user.roles.map(role => role.id);
  }

  selectRole(role: Role) {
    const isPresent: boolean = this.editedUser.roles.filter(r => r.id === role.id).length > 0;
    if (isPresent) {
      this.editedUser.roles = this.editedUser.roles.filter(r => r.id !== role.id);
    } else {
      this.editedUser.roles.push(role);
    }
  }

  isModified(): boolean {
    return this.user === this.editedUser;
  }

  emitResult() {
    this.userEventEmitter.emit(this.editedUser);
  }
}
