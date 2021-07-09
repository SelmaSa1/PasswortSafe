import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTable} from '@angular/material/table';
import {MatDialog} from '@angular/material/dialog';
import {DialogBoxComponent} from "../dialog-box/dialog-box.component";
import {HttpServiceService} from "../http-service.service";
import {Password} from "../Password";

const ELEMENT_DATA: Password[] = [];

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  displayedColumns: string[] = ['username', 'password', 'website', 'remarks', 'action'];
  dataSource = ELEMENT_DATA;

  @ViewChild(MatTable, {static: true}) table: MatTable<any>;

  constructor(public dialog: MatDialog, private httpService: HttpServiceService) {
  }


  ngOnInit(): void {
    this.httpService.getAllPassword().subscribe(data => {
      console.log(data, 'data');
      this.dataSource.splice(0, this.dataSource.length);
      this.dataSource.push(...data);
      this.table.renderRows();
    })
  }

  openDialog(action, obj) {
    obj.action = action;
    const dialogRef = this.dialog.open(DialogBoxComponent, {
      width: '350px',
      data: obj
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
      this.addRowData(result);
    });
  }

  addRowData(password) {
    this.httpService.createPassword(password.data).subscribe(() => {
      this.httpService.getAllPassword().subscribe(data => {
        this.dataSource.splice(0, this.dataSource.length);
        this.dataSource.push(...data);
        this.table.renderRows();
      })
    }, (error) => {
      console.log(error);
    });
  }

  deletePassword(id: any) {
    this.httpService.deletePassword(id).subscribe(() => {
      this.httpService.getAllPassword().subscribe(data => {
        this.dataSource.splice(0, this.dataSource.length);
        this.dataSource.push(...data);
        this.table.renderRows();
      }), (error) => {
        console.log(error);
      }
    })
  }

  logout() {
    this.httpService.logout()
  }
}





