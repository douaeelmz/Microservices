import { Component, OnInit } from '@angular/core';
import {FormsModule, ReactiveFormsModule , FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NeedingService } from '../needing.service';

@Component({
  selector: 'app-needings-form',
  templateUrl: './needings-form.component.html',
  styleUrls: ['./needings-form.component.css']
})
export class NeedingsFormComponent{
  myForm: FormGroup| undefined;


  constructor(private needingService: NeedingService) { }

  userDetails = {
      firstname:'',
      lastname: '',
      email: '',
      status: '',
      description:'',
      country: '',
      address: '',
      age: '',
      phone: '',
      skills: '',
      userId: '',
    };
  

 
  submitForm(form:any): void {
    if (form.valid) {
    this.needingService.createNeeding(this.userDetails).subscribe(
      (response) => {
        console.log('Needing added:', response);
        // Handle success, reset form, etc.
      },
      (error) => {
        console.error('Error adding needing:', error);
        // Handle error
      }
    );
  }
  }
}
