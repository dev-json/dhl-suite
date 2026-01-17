package de.dhlsuite.service;

import de.dhlsuite.data.DHLValueAddedService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DHLServiceMapper {

    public List<DHLValueAddedService> mapServices(List<String> services) {
        if (services == null) return null;

        return services.stream()
                .map(this::mapSingle)
                .filter(Objects::nonNull)
                .toList();
    }

    private DHLValueAddedService mapSingle(String service) {
        return switch (service.toLowerCase()) {
            case "gogreen" -> new DHLValueAddedService(true, false);
            case "premium" -> new DHLValueAddedService(false, false);
            case "bulky" -> new DHLValueAddedService(false, true);
            default -> null;
        };
    }

    public String mapProductType(String type) {
        return switch (type) {
            case "paket" -> "V01PAK";
            case "international" -> "V53WPAK";
            case "europaket" -> "V54EPAK";
            case "kleinpaket" -> "V62KP";
            case "warenpost" -> "V66WPI";
            default -> throw new IllegalArgumentException("Unbekannter Produkttyp: " + type);
        };
    }
}

