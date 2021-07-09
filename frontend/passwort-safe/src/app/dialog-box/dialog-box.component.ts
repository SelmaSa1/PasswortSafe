
import { Component, Inject, Optional } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {PasswordCreateTo} from "../PasswordCreateTo";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-dialog-box',
  templateUrl: './dialog-box.component.html',
  styleUrls: ['./dialog-box.component.css']
})
export class DialogBoxComponent  {
  form: FormGroup;
  action:string;
  local_data:any;

  constructor(
    public dialogRef: MatDialogRef<DialogBoxComponent>,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: PasswordCreateTo,
    private fb: FormBuilder) {

    this.form = this.fb.group({
      website: ['', Validators.required],
      username: ['', Validators.email],
      password: ['', [Validators.required, Validators.pattern('(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!#^~%*?&,.<>"\'\\;:\{\\\}\\\[\\\]\\\|\\\+\\\-\\\=\\\_\\\)\\\(\\\)\\\`\\\/\\\\\\]])[A-Za-z0-9\d$@].{7,}')]],
      remarks: ['', Validators.required],
    });
    console.log(data);
    this.local_data = {...data};
    this.action = this.local_data.action;
  }

  doAction(){
    if (this.form.valid) {
      const newPassword: PasswordCreateTo = {
        website: this.form.get('website')?.value,
        username: this.form.get('username')?.value,
        password: this.form.get('password')?.value,
        remarks: this.form.get('remarks')?.value,
      };
      this.dialogRef.close({data: newPassword});
    }
  }

  closeDialog(){
    this.dialogRef.close({event:'Cancel'});
  }
}




