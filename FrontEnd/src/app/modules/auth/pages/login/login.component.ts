import { Component } from "@angular/core";
import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule,
} from "@angular/forms";
import { AuthService } from "../../../../services/auth.service";
import { Router } from "@angular/router";
import Swal from "sweetalert2";

@Component({
  selector: "app-login",
  imports: [ReactiveFormsModule],
  standalone: true,
  templateUrl: "./login.component.html",
  styleUrl: "./login.component.css",
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      email: ["", [Validators.required, Validators.required]],
      password: ["", [Validators.required, Validators.required]],
    });
  }

  get email() {
    return this.loginForm.get("email");
  }

  get password() {
    return this.loginForm.get("password");
  }

  onSubmit() {
    this.authService.login(this.email?.value, this.password?.value).subscribe({
      next: (data) => {
        if (data) {
          this.router.navigate(["admin"]);
        }
      },
      error: (err) => {
        Swal.fire(
          "Error del servidor",
          "No se pudo completar el inicio de sesión. Inténtelo de nuevo más tarde.",
          "error"
        );
      },
    });
  }
}
