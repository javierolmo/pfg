import {Component, Input, OnInit} from '@angular/core';
import {Role, User} from '../../../../@core/data/user';
import {NbDialogService} from '@nebular/theme';
import {UserDialogComponent} from '../user-dialog/user-dialog.component';
import {RoleService} from '../../../../@core/utils/role.service';
import {ResetPasswordDialogComponent} from '../reset-password-dialog/reset-password-dialog.component';

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
    this.dialogService.open(UserDialogComponent, {context: { user: this.user, roles: this.roles }});
  }

  resetPassword() {
    this.dialogService.open(ResetPasswordDialogComponent, {context: { user: this.user }});
  }

}
