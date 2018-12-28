package com.example.mockproject.service.impl

import com.example.mockproject.entity.Vehicle
import com.example.mockproject.repository.VehicleRepository
import com.example.mockproject.service.VehicleService
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.StringUtils
import javax.persistence.EntityNotFoundException
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

@Service
@Transactional
class VehicleServiceImpl(
        private val vehicleRepository: VehicleRepository
) : VehicleService {

    override fun update(id: Long, vehicle: Vehicle): Vehicle {
        var record: Vehicle=vehicleRepository.findById(id).orElseThrow { throw EntityNotFoundException() }
        record.vin=vehicle.vin
        record.make=vehicle.make
        record.model=vehicle.model
        record.color=vehicle.color
        record.bodyType=vehicle.bodyType
        record.image=vehicle.image
        return vehicleRepository.save(record)
    }

    override fun search(vin: String?, make: String?, model: String?, color: String?, bodyType: String?): List<Vehicle> {

        val s = object : Specification<Vehicle> {

            override fun toPredicate(root: Root<Vehicle>, query: CriteriaQuery<*>, cb: CriteriaBuilder): Predicate? {
                var searchCriteria: Predicate? = null
                val allConditions = ArrayList<Predicate>()

                if (vin != null) {
                    allConditions.add(cb.like(root.get("vin"), vin))
                }

                if (!StringUtils.isEmpty(make)) {
                    allConditions.add(cb.like(root.get("make"), make))
                }

                if (!StringUtils.isEmpty(model)) {
                    allConditions.add(cb.like(root.get("model"), model))
                }

                if (!StringUtils.isEmpty(color)) {
                    allConditions.add(cb.like(root.get("color"), color))
                }

                if (!StringUtils.isEmpty(bodyType)) {
                    allConditions.add(cb.like(root.get("bodyType"), bodyType))
                }


                if (allConditions.size > 0) {
                    searchCriteria = cb.and((allConditions as List<Predicate>).toTypedArray()[0])
                }

                return searchCriteria
            }
        }
        return vehicleRepository.findAll(s)
    }

    override fun get(id: Long): Vehicle {
        return vehicleRepository.findById(id).orElseThrow { throw EntityNotFoundException() }
    }

    override fun delete(id: Long): Boolean {
        return vehicleRepository.findById(id).map { vehicle ->
            vehicleRepository.delete(vehicle)
            true
        }.orElseThrow { throw  EntityNotFoundException() }
    }

    override fun create(vehicle: Vehicle): Vehicle {
        return vehicleRepository.save(vehicle)
    }

    override fun getAll(): List<Vehicle> {
        return vehicleRepository.findAll()
    }
}
