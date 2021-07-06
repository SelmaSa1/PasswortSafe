import { Component, ViewChild } from '@angular/core';
import { MatTable } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { DialogBoxComponent } from './dialog-box/dialog-box.component';

export interface UsersData {
  website: string;
  username: string;
  password: any;
  remarks: string;
}

const ELEMENT_DATA: UsersData[] = [
  {username: 'Sangeerththani Ramesh', password: '', website: 'https://www.google.com', remarks: 'iam so happy'},
  {username: 'Sangeerththani Ramesh', password: '' , website: 'https://www.google.com', remarks: 'iam so happy'},
  {username: 'Selma Sahin', password: '' , website: 'https://www.google.com', remarks: 'iam so happy'},
  {username: 'Selma Sahin', password: '', website: 'https://www.google.com', remarks: 'iam so happy'}
];

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent {

  displayedColumns: string[] = ['username', 'password', 'website', 'remarks', 'action'];
  dataSource = ELEMENT_DATA;

  @ViewChild(MatTable,{static:true}) table: MatTable<any>;

  constructor(public dialog: MatDialog) {}

  openDialog(action,obj) {
    obj.action = action;
    const dialogRef = this.dialog.open(DialogBoxComponent, {
      width: '250px',
      data:obj
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result.event == 'Add'){
        this.addRowData(result.data);
      }else if(result.event == 'Update'){
        this.updateRowData(result.data);
      }else if(result.event == 'Delete'){
        this.deleteRowData(result.data);
      }
    });
  }

  addRowData(row_obj){
    var d = new Date();
    this.dataSource.push({
      username:d.getTime(),
      website:row_obj.website,
      username:row_obj.username,
      password:row_obj.password, 
      remarks:row_obj.remarks,
    });
    this.table.renderRows();
    
  }
  updateRowData(row_obj){
    this.dataSource = this.dataSource.filter((value,key)=>{
      if(value.username == row_obj.username){
        value.password = row_obj.password;
        value.website = row_obj.website;
        value.remarks = row_obj.remarks;

      }
      return true;
    });
  }
  deleteRowData(row_obj){
    this.dataSource = this.dataSource.filter((value,key)=>{
      return value.username != row_obj.username;
    });
  }
}





