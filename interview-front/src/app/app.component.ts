import {Component} from '@angular/core';
import {ActivatedRoute, Router, RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent{

  constructor(private router: Router) {}

  onKeydown(event: any) {
    if (event.key === "Enter") {
      if (event.target.value.trim() == "") this.router.navigateByUrl('/artwork').then(r => window.location.reload());
      else this.router.navigateByUrl('/artwork?query=' + event.target.value).then(r => window.location.reload());
    }
  }

}
