package ru.random_walk.database.matcher.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.random_walk.database.matcher.entities.AppointmentDetails;
import ru.random_walk.database.matcher.repos.AppointmentDetailsRepository;
import ru.random_walk.util.PointConverterUtils;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentDetailsFunctions {

    private final AppointmentDetailsRepository appointmentDetailsRepository;

    public AppointmentDetails getById(UUID id) {
        var appointmentDetails = appointmentDetailsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Не найдена прогулка с id = " + id));
        return appointmentDetails.setApproximateLocation(
                PointConverterUtils.convertToPoint(appointmentDetails.getApproximateLocation()).toString());
    }

    public List<AppointmentDetails> getByRequesterId(UUID requesterId) {
        return appointmentDetailsRepository.findByRequesterId(requesterId)
                .stream()
                .map(r -> r.setApproximateLocation(PointConverterUtils.convertToPoint(r.getApproximateLocation()).toString()))
                .toList();
    }

    public void deleteById(UUID id) {
        appointmentDetailsRepository.deleteById(id);
    }
}
