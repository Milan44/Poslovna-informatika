import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import {HomeComponent} from "./components/home/home.component";
import { LoginComponent } from "./components/login/login.component";
import { AnalyticsComponent } from './components/analytics/analytics.component'

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

        },
        {
            path: 'getAnalytics',
            component: AnalyticsComponent
        }
    ]

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);