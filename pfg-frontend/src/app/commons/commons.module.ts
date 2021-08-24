import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserFormComponent } from './user-form/user-form.component';
import {
  NbButtonModule,
  NbFormFieldModule,
  NbIconModule,
  NbInputModule,
  NbSelectModule,
  NbToggleModule,
} from '@nebular/theme';
import {FormsModule} from '@angular/forms';



@NgModule({
  declarations: [UserFormComponent],
  imports: [
    CommonModule,
    NbFormFieldModule,
    NbIconModule,
    NbSelectModule,
    NbToggleModule,
    NbInputModule,
    FormsModule,
    NbButtonModule,
  ],
  exports: [
    UserFormComponent,
  ],
})
export class CommonsModule { }
