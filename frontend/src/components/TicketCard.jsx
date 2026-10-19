import { jsPDF } from "jspdf";

const TicketCard = ({ booking }) => {

  const downloadPDF = () => {

    const doc = new jsPDF();

    doc.setFontSize(20);
    doc.text("MOVIE BOOKING TICKET", 20, 20);

    doc.setFontSize(12);

    doc.text(
      `Booking ID: ${booking.bookingId}`,
      20,
      40
    );

    doc.text(
      `Show ID: ${booking.showId}`,
      20,
      55
    );

    doc.text(
      `User ID: ${booking.userId}`,
      20,
      70
    );

    doc.text(
      `Number of Seats: ${booking.numberOfSeats}`,
      20,
      85
    );

    doc.text(
      `Seat Numbers: ${booking.seatNumbers?.join(", ")}`,
      20,
      100
    );

    doc.text(
      `Price: ₹${booking.price}`,
      20,
      115
    );

    doc.text(
      `Status: ${booking.bookingStatus}`,
      20,
      130
    );

    doc.text(
      `Booking Time: ${booking.bookingTime}`,
      20,
      145
    );

    doc.save(
      `Ticket-${booking.bookingId}.pdf`
    );
  };

  return (
    <div className="bg-white/10 rounded-xl p-5">
      <h2 className="text-xl font-bold mb-2">
        Ticket #{booking.bookingId}
      </h2>

      <p>Seats: {booking.numberOfSeats}</p>

      <p>
        Seat Numbers:
        {" "}
        {booking.seatNumbers?.join(", ")}
      </p>

      <p>Amount: ₹{booking.price}</p>

      <p>Status: {booking.bookingStatus}</p>

      <button
        onClick={downloadPDF}
        className="mt-4 bg-green-500 px-4 py-2 rounded-lg text-white"
      >
        Download Ticket PDF
      </button>
    </div>
  );
};

export default TicketCard;