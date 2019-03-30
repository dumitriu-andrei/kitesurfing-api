ENDPOINTS:
    - /spots : Returns all kitesurfing locations
    - /spots/{id} : Returns a specific kitesurfing location based on its id
    - /spots/country/{country} : Returns specific kitesurfing locations based on the country name
    - /spots/wind/{windProbability} : Returns specific kitesurfing locations based on the wind probability
    - /spots/countries : Returns all kitesurfing countries
    - /spots/favorites : Returns favorite kitesurfing locations
    
    - /users/me : Get username of currently logged in user
    - /favorite/{id} : Add a specific location to the user's 'favorites' list
    - /favorite/spots/{id} : Delete a specific location from the user's 'favorites' list
    
RECURRING PROBLEM: Sometimes when adding a location to the favorites list, the endpoint returns an error, but the location gets added to the list. 