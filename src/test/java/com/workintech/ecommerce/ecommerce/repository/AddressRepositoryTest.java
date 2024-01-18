package com.workintech.ecommerce.ecommerce.repository;

import com.workintech.ecommerce.ecommerce.entity.Address;
import com.workintech.ecommerce.ecommerce.entity.Role;
import com.workintech.ecommerce.ecommerce.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AddressRepositoryTest {
    private AddressRepository addressRepository;
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    @Autowired
    public AddressRepositoryTest(AddressRepository addressRepository, RoleRepository
            roleRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @BeforeEach
    void setUp() {
        User user = new User();


        Role role = roleRepository.findByAuthority("customer").get();
        user.setName("Test");
        user.setEmail("test@test.com");
        user.setRole(role);
        user.setPassword("12345678");
        Address address = new Address();
        address.setTitle("ev");
        address.setName("test");
        address.setSurname("testSoyad");
        address.setPhone("5555555555");
        address.setCity("Samsun");
        address.setDistrict("İlkadım");
        address.setNeighborhood("Kuşadası");
        address.setAddress("no:2 address");
        address.setUser(user);

        user.addAddress(address);
        // addressRepository.save(address);
        //userRepository.save(user);
    }

    @Test
    @DisplayName("Can find Address by id")
    void findAddressByID() {
        User presentUser = new User();
        Address presentAddress = new Address();

        Optional<Address> foundAddress = addressRepository.findAddressByID(3);
        if (foundAddress.isPresent()) {
            presentAddress = foundAddress.get();
        }
        assertEquals(3, presentAddress.getId());
    }
}