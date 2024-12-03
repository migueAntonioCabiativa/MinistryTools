import { Component } from "@angular/core";
import { FormsModule } from "@angular/forms";

@Component({
  selector: "app-register",
  imports: [FormsModule],
  templateUrl: "./register.component.html",
  styleUrl: "./register.component.css",
})
export class RegisterComponent {
  user = {
    name: "",
    username: "",
    password: "",
  };

  onSubmit() {
    console.log("Usuario creado:", this.user);
    alert("Usuario creado con éxito!");
    this.resetForm();
  }

  resetForm() {
    this.user = {
      name: "",
      username: "",
      password: "",
    };
  }
}
