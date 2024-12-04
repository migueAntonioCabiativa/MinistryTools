import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User } from "../models/User";
import { HttpClient, HttpParams } from "@angular/common/http";

@Injectable({
  providedIn: "root",
})
export class AuthService {
  private apiUrl = "http://localhost:8080/api/login";

  constructor(private http: HttpClient) {}

  // Método para validar login
  login(user: string, password: string): Observable<any> {
    const params = new HttpParams().set("user", user).set("password", password);
    return this.http.get<any>(`${this.apiUrl}/search?`, { params });
  }
}
