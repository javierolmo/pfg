import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {Role, User} from '../../../../@core/data/user';
import {RoleService} from '../../../../@core/utils/role.service';
import {NbDialogRef, NbToastrService} from '@nebular/theme';
import {UserService} from '../../../../@core/utils/user.service';
import {UserFormComponent} from '../../../../commons/user-form/user-form.component';

@Component({
  selector: 'ngx-user-edit-form',
  templateUrl: './user-dialog.component.html',
  styleUrls: ['./user-dialog.component.scss'],
})
export class UserDialogComponent implements OnInit {

  user: User;
  roles: Role[];

  @ViewChild(UserFormComponent) form: UserFormComponent;

  constructor(
      protected dialogRef: NbDialogRef<any>,
      protected userService: UserService,
      protected toastrService: NbToastrService,
  ) {

  }


  ngOnInit(): void {
  }


  cancel() {
    this.dialogRef.close();
  }

  update(editedUser: User) {
    this.userService.put(this.user.id, editedUser).subscribe(
        success => {
          this.toastrService.success('User modified successfuly', 'SUCCESS');
          this.user.id = editedUser.id;
          this.user.roles = editedUser.roles;
          this.user.name = editedUser.name;
          this.user.surname = editedUser.surname;
          this.user.enabled = editedUser.enabled;
          this.user.email = editedUser.email;
          this.dialogRef.close();
        },
        error => this.toastrService.danger(error.error, 'ERROR'),
    );
  }

  save() {
    this.form.emitResult();
  }
}
