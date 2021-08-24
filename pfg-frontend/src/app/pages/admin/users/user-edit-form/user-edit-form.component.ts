import {Component, Input, OnInit} from '@angular/core';
import {Role, User} from '../../../../@core/data/user';
import {RoleService} from '../../../../@core/utils/role.service';
import {NbDialogRef, NbToastrService} from '@nebular/theme';
import {UserService} from '../../../../@core/utils/user.service';

@Component({
  selector: 'ngx-user-edit-form',
  templateUrl: './user-edit-form.component.html',
  styleUrls: ['./user-edit-form.component.scss'],
})
export class UserEditFormComponent implements OnInit {

  user: User;
  roles: Role[];

  constructor(
      protected dialogRef: NbDialogRef<any>,
      protected userService: UserService,
      protected toastrService: NbToastrService,
  ) {}


  ngOnInit(): void {
  }


  cancel() {
    this.dialogRef.close();
  }

  save() {
    this.userService.put(this.user.id, this.user).subscribe(
        success => this.toastrService.success('User modified successfuly'),
        error => {this.toastrService.danger(error.error), console.log(error)}
    );
  }
}
