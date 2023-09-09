api
    @GetMapping("/getAllEmploymentType")
    @CrossOrigin
    public ResponseEntity<List<EmploymentType>> getAllEmploymentTypes() {
        try {
            return new ResponseEntity<>(employmentTypeService.getAllEmType(),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addOrUpdateEmType")
    @CrossOrigin
    public ResponseEntity addOrUpdateEmType(@RequestBody EmploymentType employmentType) {
        try {
            if (employmentTypeService.addOrUpdateEmType(employmentType) == true) {
                return ResponseEntity.ok("{\"result\":\"success\"}");
            } else {
                return ResponseEntity.ok("{\"result\":\"failed\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteEmTypeById/{id}")
    @CrossOrigin
    public ResponseEntity deleteEmploymentType(@PathVariable int id) {
        try {
            if (employmentTypeService.deleteEmTypeById(id) == true) {
                return ResponseEntity.ok("{\"result\":\"success\"}");
            } else {
                return ResponseEntity.ok("{\"result\":\"failed\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }