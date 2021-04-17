import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import {NbDialogService, NbToastrService} from '@nebular/theme';
import { Sheet } from 'app/@core/data/sheet';
import { SheetService } from 'app/@core/utils/sheet.service';
import { environment } from 'environments/environment';
import { SheetDialogComponent } from './sheet-dialog/sheet-dialog.component';
import {DownloadDialogComponent} from './download-dialog/download-dialog.component';

@Component({
  selector: 'ngx-repositorio',
  templateUrl: './repositorio.component.html',
  styleUrls: ['./repositorio.component.scss'],
})
export class RepositorioComponent implements OnInit {

  sheets: Sheet[] = [];
  busquedaForm: FormGroup;
  text: string = '';
  loading: boolean = false;

  constructor(
    private sheetService: SheetService,
    public dialog: MatDialog,
    private _snackBar: MatSnackBar,
    private formBuilder: FormBuilder,
    private nbDialogService: NbDialogService,
    private toastrService: NbToastrService,
    private dialogService: NbDialogService,
  ) {
    this.busquedaForm = formBuilder.group({
      text: '',
    });
  }

  ngOnInit(): void {
    this.refreshSheets(undefined);
  }

  refreshSheets(filter: string): void {
    this.loading = true;
    this.sheetService.getSheets(filter).subscribe(value => {
      this.sheets = value;
      this.loading = false;
    });
  }

  onSubmit(formValue) {
    this.text = formValue.text;
    if (this.busquedaForm.valid) {
      this.refreshSheets(this.text);
    }
  }

  openDownloadDialog(id: number) {
    this.dialogService.open(DownloadDialogComponent, {
      context: {
        sheetId: id,
      },
    });
  }

  downloadSheet(id: number) {
    window.location.href = `${environment.apiUrl}/sheets/${id}/download/xml`;
  }

  deleteSheet(id: number) {
    this.sheetService.deleteSheet(id).subscribe(
      value => {
        this.showToast('Partitura eliminada con éxito!', 'Éxito', 'top-right', 'success');
        this.refreshSheets(this.text);
      },
      error => {
        this.showToast('No se ha podido eliminar la partitura', 'Error', 'top-right', 'danger');
      });
  }

  private snackMessage(message: string) {
    this._snackBar.open(message, 'OK', { duration: 2000});
  }

  openSheet(id: number) {
    this.nbDialogService.open(SheetDialogComponent, {
      context: {
        sheetId: id,
      },
    });
  }

  showToast(message, title, position, status) {
    this.toastrService.show(message, title, { position, status });
  }

}
