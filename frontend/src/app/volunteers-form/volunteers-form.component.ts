import { Component, OnInit } from '@angular/core';
import {FormsModule, ReactiveFormsModule , FormGroup, FormBuilder, Validators } from '@angular/forms';
import { VolunteerService } from '../volunteer.service';
@Component({
  selector: 'app-volunteers-form',
  templateUrl: './volunteers-form.component.html',
  styleUrls: ['./volunteers-form.component.css']
})
export class VolunteersFormComponent  {
  myForm: FormGroup | undefined;

  constructor(private volunteerService: VolunteerService) { }
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
      this.volunteerService.addVolunteer(this.userDetails).subscribe(
        (response) => {
          console.log('Volunteer added:', response);
          // Handle success, reset form, etc.
        },
        (error) => {
          console.error('Error adding volunteer:', error);
          // Handle error
        }
      );
    }
  }

}
