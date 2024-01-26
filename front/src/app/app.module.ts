import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { RecargaComponent } from './recarga/recarga.component';

@NgModule({
  declarations: [
    AppComponent,
    RecargaComponent
    // otros componentes aquí...
  ],
  imports: [
    BrowserModule,
    // otros módulos aquí...
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
