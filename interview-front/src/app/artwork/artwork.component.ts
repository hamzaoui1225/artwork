import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ArtworkService} from '../../service/artwork.service';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-artwork',
  templateUrl: './artwork.component.html',
  styleUrl: './artwork.component.css',
  imports: [NgIf]
})
export class ArtworkComponent implements OnInit {
  id: any;
  artwork: any;
  constructor(private activatedRoute: ActivatedRoute,private service: ArtworkService) {}

  ngOnInit() {
    this.id = this.activatedRoute.snapshot.paramMap.get('id');
    this.artwork = this.service.getArtWorkById(this.id).subscribe((data) => { this.artwork = data } );
    console.log(this.artwork)
  }
}
