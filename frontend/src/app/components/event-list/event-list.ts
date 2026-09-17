import { Component, inject } from '@angular/core';
import { toSignal } from '@angular/core/rxjs-interop';
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';
import { MatButtonModule } from '@angular/material/button';
import { EventService } from '../../services/event';
import { Event } from '../../models/event';

@Component({
  selector: 'app-event-list',
  standalone: true,
  imports: [MatCardModule, MatChipsModule, MatButtonModule],
  templateUrl: './event-list.html',
  // Si tu n'as pas de fichier css pour le moment, tu peux vider ou commenter :
  styles: [`
    .event-card {
      max-width: 400px;
      margin: 16px auto;
    }
  `]
})
export class EventListComponent {
  private eventService = inject(EventService);

  events = toSignal(this.eventService.getEvents(), { initialValue: [] as Event[] });
}