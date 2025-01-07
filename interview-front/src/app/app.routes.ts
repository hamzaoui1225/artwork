import {Routes} from '@angular/router';
import {ArtworkComponent} from './artwork/artwork.component';
import {ArtworksComponent} from './artworks/artworks.component';

export const routes: Routes = [
  { path: "artwork/:id", component: ArtworkComponent },
  { path: 'artwork', component: ArtworksComponent },
];
