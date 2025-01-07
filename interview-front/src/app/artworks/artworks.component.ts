import {Component, OnInit, signal} from '@angular/core';
import {ArtworkService} from '../../service/artwork.service';
import {NgFor, NgIf} from '@angular/common';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {map, Observable} from 'rxjs';
import {query} from '@angular/animations';
import {ArtWorkList} from '../../types/artwork';

@Component({
  selector: 'app-artworks',
  imports: [NgFor, NgIf],
  templateUrl: './artworks.component.html',
  styleUrl: './artworks.component.css'
})
export class ArtworksComponent implements OnInit{


  artworks: any;
  page: number = 1;
  query: string | null = null;

  public loading = true;

  constructor(private activatedRoute: ActivatedRoute, private service: ArtworkService) {}

  ngOnInit() {

    let queryQ = this.activatedRoute.queryParamMap.pipe(
      map((params: ParamMap) => params.get('query')),
    );

    queryQ.subscribe(param => {
      this.query = param
    });

    this.refreshArtWork();
  }

  refreshArtWork() {
    this.loading = true;
    if (this.query) this.artworks = this.service.findArtWork(this.query as string,this.page).subscribe((data) => { this.artworks = data; this.loading = false });
    else this.artworks = this.service.getArtWorks(this.page).subscribe((data) => { this.artworks = data; this.loading = false });
  }

  nextPage() {
    this.page++;
    this.refreshArtWork();
  }
  previousPage() {
    this.page--;
    this.refreshArtWork();
  }

}
