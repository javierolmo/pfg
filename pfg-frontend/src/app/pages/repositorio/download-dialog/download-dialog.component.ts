import {Component, Input, OnInit} from '@angular/core';
import {environment} from '../../../../environments/environment';
import {NbDialogRef} from "@nebular/theme";

@Component({
  selector: 'ngx-download-dialog',
  templateUrl: './download-dialog.component.html',
  styleUrls: ['./download-dialog.component.scss'],
})
export class DownloadDialogComponent implements OnInit {

  @Input()
  sheetId: number;

  constructor(private dialogRef: NbDialogRef<DownloadDialogComponent>) { }

  ngOnInit(): void {

  }

  downloadMusicXML() {
    window.location.href = `${environment.apiUrl}/sheets/${(this.sheetId)}/file/musicxml`;
    this.dialogRef.close();
  }

  downloadPDF() {
    window.location.href = `${environment.apiUrl}/sheets/${(this.sheetId)}/file/pdf`;
    this.dialogRef.close();
  }

  close() {
    this.dialogRef.close();
  }

}
