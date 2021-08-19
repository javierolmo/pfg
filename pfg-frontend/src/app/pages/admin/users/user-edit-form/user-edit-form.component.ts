import {Component, Input, OnInit} from '@angular/core';
import {Role, User} from '../../../../@core/data/user';
import {RoleService} from '../../../../@core/utils/role.service';

@Component({
  selector: 'ngx-user-edit-form',
  templateUrl: './user-edit-form.component.html',
  styleUrls: ['./user-edit-form.component.scss'],
})
export class UserEditFormComponent implements OnInit {

  user: User;
  roles: Role[];

  constructor() {}


  ngOnInit(): void {
  }


}
