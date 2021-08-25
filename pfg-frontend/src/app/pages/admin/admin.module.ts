import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { LogsComponent } from './logs/logs.component';
import { AdminComponent } from './admin.component';
import {
    NbActionsModule,
    NbAlertModule, NbButtonModule,
    NbCardModule, NbFormFieldModule,
    NbIconModule,
    NbInputModule,
    NbListModule, NbSelectModule, NbSpinnerModule, NbToggleModule, NbTooltipModule,
    NbTreeGridDataSourceBuilder,
    NbTreeGridModule,
} from '@nebular/theme';
import {AdminService} from '../../@core/utils/admin.service';
import { LogComponent } from './logs/log/log.component';
import { UsersComponent } from './users/users.component';
import { UserLiComponent } from './users/user-li/user-li.component';
import { UserDialogComponent } from './users/user-dialog/user-dialog.component';
import {RoleService} from '../../@core/utils/role.service';
import {CommonsModule} from '../../commons/commons.module';
import { ResetPasswordDialogComponent } from './users/reset-password-dialog/reset-password-dialog.component';
import {FormsModule} from "@angular/forms";


@NgModule({
    declarations: [
        LogsComponent,
        AdminComponent,
        LogComponent,
        UsersComponent,
        UserLiComponent,
        UserDialogComponent,
        ResetPasswordDialogComponent],
    imports: [
        CommonModule,
        AdminRoutingModule,
        NbCardModule,
        NbTreeGridModule,
        NbInputModule,
        NbListModule,
        NbIconModule,
        NbSpinnerModule,
        NbAlertModule,
        NbActionsModule,
        NbToggleModule,
        NbFormFieldModule,
        NbSelectModule,
        CommonsModule,
        NbButtonModule,
        NbTooltipModule,
        FormsModule,
    ],
  providers: [NbTreeGridDataSourceBuilder, AdminService, RoleService],
})
export class AdminModule { }
