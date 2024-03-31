def solution(tickets):    
    ticket_dict = {}
    for idx in range(len(tickets)):
        start, end = tickets[idx]
        
        if start not in ticket_dict:
            ticket_dict[start] = []
        ticket_dict[start].append((end, idx))
        ticket_dict[start].sort()
    
    visited = [False] * len(tickets)
    def dfs(current_city, routes):
        nonlocal ticket_dict, visited

        if len(routes) == len(tickets) + 1:
            return routes

        if current_city not in ticket_dict:
            return
        
        for next_city, idx in ticket_dict[current_city]:
            if visited[idx]:
                continue
            
            visited[idx] = True
            routes.append(next_city)
            result = dfs(next_city, routes)
            if result:
                return result
            routes.pop()
            visited[idx] = False
    
    return dfs("ICN", ["ICN"])