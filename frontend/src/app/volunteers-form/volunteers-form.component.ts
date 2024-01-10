import { Component, OnInit } from '@angular/core';
import {FormsModule, ReactiveFormsModule , FormGroup, FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-volunteers-form',
  templateUrl: './volunteers-form.component.html',
  styleUrls: ['./volunteers-form.component.css']
})
export class VolunteersFormComponent  {
  myForm: FormGroup | undefined;

  constructor(private formBuilder: FormBuilder) { }

  userDetails = {
    id:'',
    firstname: '',
    lastname: '',
    email: '',
    status: '',
    description: '',
    country:'',
    address: '',
    age: '',
    phone: '',
    skills: '',
    availability: '',
    userId: '',
  };


  submitForm(form: any): void {
    if (form.valid) {
      console.log('Form data:', this.userDetails);
    }
  }

}
