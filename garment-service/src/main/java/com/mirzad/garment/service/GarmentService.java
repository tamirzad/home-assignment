package com.mirzad.garment.service;

import com.mirzad.common.model.User;
import com.mirzad.common.utils.JwtUtil;
import com.mirzad.garment.client.UserServiceClient;
import com.mirzad.garment.dto.GarmentDto;
import com.mirzad.garment.exc.NotFoundException;
import com.mirzad.garment.model.Garment;
import com.mirzad.garment.repository.GarmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GarmentService {

    private final GarmentRepository garmentRepository;
    private final JwtUtil jwtUtil;
    private final UserServiceClient userServiceClient;

    /**
     *
     * @param garmentDto - Garment we want to save in database. If already exists, it won't be saved.
     * @param jwt - Authentication
     */
    public void save(GarmentDto garmentDto, String jwt){

        User user = getUserFromToken(jwt);
        user.setPublisher(true);

        Garment toSave = Garment.builder()
                .size(garmentDto.getSize())
                .type(garmentDto.getType())
                .price(garmentDto.getPrice())
                .publisherId(user)
                .description(garmentDto.getDescription())
                .build();

        garmentRepository.save(toSave);
    }

    /**
     * Deletes garment from database. Only user published that garment can delete it.
     * @param id - garment id we want to be deleted
     * @param jwt - authentication
     */
    public void deleteGarmentById(Long id, String jwt){
        User user = getUserFromToken(jwt);
        Garment garment = getGarmentById(id);

        if(!user.getId().equals(garment.getPublisherId().getId())) {
            throw new RuntimeException("User not allowed to delete this garment!");
        }

        garmentRepository.delete(garment);
    }

    /**
     * Getting garment from database by its id.
     * @param id - Garment's id
     * @return garment by its id
     */
    public Garment getGarmentById(Long id){
        return garmentRepository.findById(id)
                .orElseThrow
                        (() -> new NotFoundException("User not found"));
    }

    private User getUserFromToken(String token){
        String username = null;

        if (token != null){
            username = jwtUtil.getClaims(token).getSubject();
        }

        return userServiceClient.getUserByUsername(username).getBody();
    }

    /**
     * Updates the garment by its id.
     * @param garmentId - garment to be updated
     * @param updated - new garment with updated info
     * @param jwt - authentication
     * @return updated garment
     */

    public Garment updateGarment(Long garmentId, Garment updated, String jwt) {
        User user = getUserFromToken(jwt);
        Garment garment = getGarmentById(garmentId);

        if(!user.getId().equals(garment.getPublisherId().getId())) {
            throw new RuntimeException("User not allowed to update this garment!");
        }

        garment.setDescription(updated.getDescription());
        garment.setSize(updated.getSize());
        garment.setPrice(updated.getPrice());
        garment.setPublisherId(updated.getPublisherId());
        garment.setType(updated.getType());

        return garmentRepository.save(garment);

    }
}
