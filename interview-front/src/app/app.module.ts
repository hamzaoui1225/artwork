import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import {ArtworkComponent} from './artwork/artwork.component';
import {NgOptimizedImage} from '@angular/common';
import {RouterModule, RouterOutlet} from '@angular/router';
import {ArtworksComponent} from './artworks/artworks.component';

@NgModule({
  declarations: [
    AppComponent,
    ArtworkComponent,
    ArtworksComponent,
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    NgOptimizedImage,
    RouterOutlet,
    RouterModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
