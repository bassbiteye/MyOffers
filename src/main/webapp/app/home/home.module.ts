import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MyOffersSharedModule } from 'app/shared/shared.module';
import { HOME_ROUTE } from './home.route';
import { HomeComponent } from './home.component';

@NgModule({
  imports: [MyOffersSharedModule, RouterModule.forChild([HOME_ROUTE])],
  declarations: [HomeComponent],
})
export class MyOffersHomeModule {}
