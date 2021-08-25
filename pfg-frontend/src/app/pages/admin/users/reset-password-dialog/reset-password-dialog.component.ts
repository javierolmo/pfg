import {Component, Input, OnInit} from '@angular/core';
import {User} from '../../../../@core/data/user';
import {NbDialogRef, NbToastrService} from "@nebular/theme";
import {UserService} from "../../../../@core/utils/user.service";

@Component({
  selector: 'ngx-reset-password-dialog',
  templateUrl: './reset-password-dialog.component.html',
  styleUrls: ['./reset-password-dialog.component.scss'],
})
export class ResetPasswordDialogComponent implements OnInit {

  @Input()
  user: User;
  newPassword: string;

  constructor(
      protected dialogRef: NbDialogRef<any>,
      protected userService: UserService,
      protected toastrService: NbToastrService) { }

  ngOnInit(): void {
  }

  cancel() {
    this.dialogRef.close();
  }

  submit() {
    this.userService.resetPassword(this.user.id, this.newPassword).subscribe(
        user => this.toastrService.success('Password was modified successfuly', 'SUCCESS'),
        error => {
          this.toastrService.danger(error.error, 'ERROR');
        },
    );
    this.dialogRef.close();
  }
}
