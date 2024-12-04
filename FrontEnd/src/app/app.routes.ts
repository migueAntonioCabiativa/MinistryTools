import { Routes } from "@angular/router";

export const routes: Routes = [
  {
    path: "auth",
    loadChildren: () =>
      import("./modules/auth/auth.routes").then((module) => module.routes),
  },
  {
    path: "admin",
    loadChildren: () =>
      import("./modules/admin/admin.routes").then((module) => module.routes),
  },
  {
    path: "**",
    redirectTo: "/auth/login",
    pathMatch: "full",
  },
];
