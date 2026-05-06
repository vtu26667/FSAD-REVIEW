import React, { useEffect, useState } from "react";

export default function Events() {
  const [events, setEvents] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8082/api/events")
      .then(res => res.json())
      .then(data => setEvents(data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div className="p-8">
      <h1 className="text-3xl font-bold mb-6">Campus Events</h1>

      {events.length === 0 ? (
        <p className="text-gray-500">No upcoming events.</p>
      ) : (
        <div className="grid grid-cols-3 gap-6">
          {events.map(event => {
            const remaining = event.capacity - event.booked;

            return (
              <div key={event.id} className="border p-4 rounded-xl shadow">
                <h2 className="text-xl font-bold">{event.name}</h2>
                <p className="text-sm text-gray-500">{event.description}</p>

                <div className="mt-2 text-sm">
                  <p>📅 {event.eventDate}</p>
                  <p>⏰ {event.time}</p>
                  <p>📍 {event.location}</p>
                </div>

                <p className="mt-2 text-green-600 font-semibold">
                  {remaining} spots left
                </p>
              </div>
            );
          })}
        </div>
      )}
    </div>
  );
}