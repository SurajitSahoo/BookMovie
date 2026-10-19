import { useEffect, useState } from "react";
import { getUserBookings } from "../../services/bookingService";
import { useAuth } from "../../context/AuthContext";
import TicketCard from "../../components/TicketCard";

const Tickets = () => {

  const { user } = useAuth();

  const [tickets, setTickets] = useState([]);

  useEffect(() => {
    if (user?.userId) {
      loadTickets();
    }
  }, [user]);

  const loadTickets = async () => {
    try {
      const data = await getUserBookings(user.userId);

      const confirmed = data.filter(
        booking => booking.bookingStatus === "CONFIRMED"
      );

      setTickets(confirmed);

    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="p-6">

      <h1 className="text-3xl font-bold mb-6">
        My Tickets
      </h1>

      <div className="grid md:grid-cols-3 gap-5">

        {tickets.map((ticket) => (
          <TicketCard
            key={ticket.bookingId}
            booking={ticket}
          />
        ))}

      </div>

    </div>
  );
};

export default Tickets;