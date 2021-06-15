#include <iostream>
#include <bits/stdc++.h>
using namespace std;

struct Pair {
    string name;
    int infectionLevel;

    Pair(string name, int infectionLevel) : name(name), infectionLevel(infectionLevel) {
    }
    
    string toString() {
        return name;
    }
};

struct ComparePair {
    bool operator() (Pair const& p1, Pair const& p2) {
        return p2.infectionLevel > p1.infectionLevel;
    }
};

void addCatToQueue(string catName, int infectionLevel, priority_queue<Pair, vector<Pair>, ComparePair> pq, unordered_map<string, int> map) {
    pq.push(Pair(catName, infectionLevel));
    map[catName] = infectionLevel;
}

void updateCatInfection(string catName, int infectionLevel, priority_queue<Pair, vector<Pair>, ComparePair> pq, unordered_map<string, int> map) {
    int currInfectionLevel = map[catName];
    int newInfectionLevel = min(100, currInfectionLevel + infectionLevel);
    pq.push(Pair(catName, newInfectionLevel));
    map[catName] = newInfectionLevel;
}

void treatCat(string catName, priority_queue<Pair, vector<Pair>, ComparePair> pq, unordered_map<string, int> map) {
    vector<Pair> temp;

    while (true) {
        Pair p = pq.top();
        pq.pop();
        if (p.name == catName) {
            break;
        } else {
            temp.push_back(p);
        }
    }

    map.erase(catName);
    while (!temp.empty()) {
        Pair toAdd = temp.back();
        pq.push(toAdd);
        temp.pop_back();
    }
}

void queryQueue(priority_queue<Pair, vector<Pair>, ComparePair> pq, unordered_map<string, int> map) {
    while (true && !pq.empty()) {
        if (map.find(pq.top().name) != map.end()) {
            pq.pop();
        } else {
            break;
        }
    }

    if (pq.empty()) {
        cout << "The clinic is empty" << endl;
    } else {
        Pair ans = pq.top();
        cout << ans.name << endl;
    }
}

void executeCommand(int command, priority_queue<Pair, vector<Pair>, ComparePair> pq, unordered_map<string, int> map) {
    switch (command) {
        case 0: {
            string catName;
            int infectionLevel;
            cin >> catName;
            cin >> infectionLevel; 
            cin.get();

            addCatToQueue(catName, infectionLevel, pq, map);
            break;
        }
        case 1: {
            string catName;
            int infectionLevelToAdd;
            cin >> catName;
            cin >> infectionLevelToAdd;

            updateCatInfection(catName, infectionLevelToAdd, pq, map);
            break;
        }
        case 2: {
            string catNameToTreat;
            cin >> catNameToTreat;

            treatCat(catNameToTreat, pq, map);
            break;
        }
        case 3: {
            queryQueue(pq, map);
            break;
        }
    }
}

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL);
    int n; cin >> n; cin.get();
    priority_queue<Pair, vector<Pair>, ComparePair> pq;
    unordered_map<string, int> map;


    while (n--) {
        int command; cin >> command;
        executeCommand(command, pq, map);
    }

    return 0;
}