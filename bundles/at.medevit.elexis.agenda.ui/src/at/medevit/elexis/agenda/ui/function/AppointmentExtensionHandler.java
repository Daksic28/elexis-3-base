package at.medevit.elexis.agenda.ui.function;

import ch.elexis.core.model.IAppointment;
import ch.elexis.core.services.holder.CoreModelServiceHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentExtensionHandler {

	public static final String MAIN_PREFIX = "Main:";
	public static final String KOMBI_PREFIX = "Kombi:";

	/**
	 * Retrieves the main appointment ID from the extension of the appointment.
	 *
	 * @param appointment the appointment
	 * @return the main appointment ID or null if not present
	 */
	public static String getMainAppointmentId(IAppointment appointment) {
		String extension = appointment.getExtension();
		if (extension != null && !extension.isEmpty()) {
			return extractIdByPrefix(extension, MAIN_PREFIX);
		}
		return null;
	}

	/**
	 * Checks if an appointment is the main appointment (marked by "Main:" in the
	 * extension).
	 *
	 * @param appointment the appointment to check
	 * @return true if the appointment is a main appointment, otherwise false
	 */
	public static boolean isMainAppointment(IAppointment appointment) {
		String mainId = getMainAppointmentId(appointment);
		return appointment.getId().equals(mainId);
	}

	/**
	 * Retrieves the IDs of linked appointments (Kombi) from the extension of the
	 * main appointment.
	 *
	 * @param mainAppointment the main appointment
	 * @return a list of linked appointments
	 */
	public static List<IAppointment> getLinkedAppointments(IAppointment mainAppointment) {
		List<IAppointment> linkedAppointments = new ArrayList<>();
		String extension = mainAppointment.getExtension();

		if (extension != null && !extension.isEmpty()) {
			String[] parts = extension.split(",");
			for (String part : parts) {
				if (part.startsWith(KOMBI_PREFIX)) {
					String id = part.replace(KOMBI_PREFIX, "").trim();
					Optional<IAppointment> linkedAppointment = CoreModelServiceHolder.get().load(id,
							IAppointment.class);
					linkedAppointment.ifPresent(linkedAppointments::add);
				}
			}
		}
		return linkedAppointments;
	}

	/**
	 * Inserts a new main appointment ID into the extension.
	 *
	 * @param appointment the appointment
	 * @param mainId      the ID of the main appointment
	 */
	public static void setMainAppointmentId(IAppointment appointment, String mainId) {
		StringBuilder extensionBuilder = new StringBuilder();
		String currentExtension = appointment.getExtension();
		if (currentExtension != null && !currentExtension.isEmpty()) {
			// Remove old Main and Kombi entries
			String[] parts = currentExtension.split("\\|\\|");
			for (String part : parts) {
				if (!part.startsWith(MAIN_PREFIX) && !part.startsWith(KOMBI_PREFIX)) {
					extensionBuilder.append(part).append("||");
				}
			}
		}
		extensionBuilder.append(MAIN_PREFIX).append(mainId);
		appointment.setExtension(extensionBuilder.toString());
	}

	/**
	 * Inserts a new linked appointment ID into the extension.
	 *
	 * @param appointment the appointment
	 * @param linkedId    the ID of the linked appointment
	 */
	public static void addLinkedAppointmentId(IAppointment appointment, String linkedId) {
		StringBuilder extensionBuilder = new StringBuilder(
				appointment.getExtension() != null ? appointment.getExtension() + "," : "");
		extensionBuilder.append(KOMBI_PREFIX).append(linkedId);
		appointment.setExtension(extensionBuilder.toString());
	}

	private static String extractIdByPrefix(String extension, String prefix) {
		String[] parts = extension.split(",");
		for (String part : parts) {
			if (part.startsWith(prefix)) {
				return part.replace(prefix, "").trim();
			}
		}
		return null;
	}

    /**
	 * Inserts multiple linked appointment IDs into the extension of a main
	 * appointment.
	 *
	 * @param mainAppointment      The main appointment to which the links are
	 *                             added.
	 * @param linkedAppointmentIds The list of IDs of the linked appointments.
	 */
    public static void addMultipleLinkedAppointments(IAppointment mainAppointment, List<String> linkedAppointmentIds) {
		StringBuilder extensionBuilder = new StringBuilder(
				mainAppointment.getExtension() != null ? mainAppointment.getExtension() + "," : "");
        for (String linkedId : linkedAppointmentIds) {
            extensionBuilder.append(KOMBI_PREFIX).append(linkedId).append(",");
        }
        if (extensionBuilder.length() > 0 && extensionBuilder.charAt(extensionBuilder.length() - 1) == ',') {
            extensionBuilder.setLength(extensionBuilder.length() - 1);
        }
        mainAppointment.setExtension(extensionBuilder.toString());
    }
}