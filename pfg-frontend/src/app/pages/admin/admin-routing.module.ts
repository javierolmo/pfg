import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {NotFoundComponent} from '../miscellaneous/not-found/not-found.component';
import {LogsComponent} from './logs/logs.component';
import {AdminComponent} from './admin.component';
import {UsersComponent} from './users/users.component';

const routes: Routes = [{
  path: '',
  component: AdminComponent,
  children: [
    {
      path: 'logs',
      component: LogsComponent,
    },
    {
      path: 'users',
      component: UsersComponent,
    },
    {
      path: '**',
      component: NotFoundComponent,
    },
  ],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AdminRoutingModule { }
