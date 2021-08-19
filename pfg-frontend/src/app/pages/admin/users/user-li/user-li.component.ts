import {Component, Input, OnInit} from '@angular/core';
import {Role, User} from '../../../../@core/data/user';
import {NbDialogService} from '@nebular/theme';
import {UserEditFormComponent} from '../user-edit-form/user-edit-form.component';
import {RoleService} from '../../../../@core/utils/role.service';

@Component({
  selector: 'ngx-user-li',
  templateUrl: './user-li.component.html',
  styleUrls: ['./user-li.component.scss'],
})
export class UserLiComponent implements OnInit {

  @Input()
  user: User;
  roles: Role[];

  constructor(public dialogService: NbDialogService, public roleService: RoleService) { }

  ngOnInit(): void {
    this.roleService.getRoles().subscribe(
        roles => this.roles = roles,
        error => this.roles = []);
  }

  openEditDialog() {
    this.dialogService.open(UserEditFormComponent, {context: { user: this.user, roles: this.roles }});
  }

}
