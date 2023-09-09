ServiceImpl
    @Override
    public List<EmploymentType> getAllEmType() {
        return employmentTypeRepository.getAllEmType();
    }

    @Override
    public Boolean addOrUpdateEmType(EmploymentType employmentType) {
        if(!employmentType.getEmployment().isEmpty()){
            return employmentTypeRepository.addOrUpdateEmType(employmentType);
        }else{
            return false;
        }
    }

    @Override
    public Boolean deleteEmTypeById(int id) {
        if(id >= 1){
            return employmentTypeRepository.deleteEmTypeById(id);
        }else{
            return false;
        }
    }