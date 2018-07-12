import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import {HomeComponent} from "./components/home/home.component";
import { LoginComponent } from "./components/login/login.component";

const appRoutes: Routes =
    [
        {
            path: '',
            redirectTo: '/login',
            pathMatch: 'full'
        },
        {
            path: 'login',
            component: LoginComponent

        },
        {
            path: 'home',
            component: HomeComponent

        }
    ]

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);