import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { toSignal } from '@angular/core/rxjs-interop';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatChipsModule } from '@angular/material/chips';
import { EventService } from '../../services/event';
import { Event } from '../../models/event';

@Component({
  selector: 'app-event-list',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatButtonModule, MatChipsModule],
  templateUrl: './event-list.html',
  styleUrl: './event-list.scss'
})
export class EventListComponent {
  private eventService = inject(EventService);

  events = toSignal(this.eventService.getEvents(), { initialValue: [] as Event[] });
}