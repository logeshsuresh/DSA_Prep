radians = []
num_points = int(input("Enter the number of chords: ")) 
for i in range(num_points * 2): 
    value = float(input(f"Enter radians {i+1}: "))  # Prompt the user for input and convert it to float
    radians.append(value)  # Append the input radians to the list

# Generate the labels for start 's' and end 'e' based on the number of points
labels = ['s' + str(i+1) if i < num_points else 'e' + str(i+1 - num_points) for i in range(len(radians))]
# Create the chord-list using the radians and labels
chords = (tuple(radians), tuple(labels))

angles = chords[0]
chords = chords[1]

n = len(angles)

chord_map = {} # dictionary to store the key as chordNum and value as a list with pair of values [startPoint, endPoint] -> in radians

chordPairSet = set() # Set to store the chords computed (chords checked till not if there is an intersection)

num_intersections = 0

"""
    chord_map = {
            '1': [0.78, 1.77],
            '2': [1.47, 3.92]
        }

    KEY   : CHORD NUMBER
    VALUE : [startPoint, endPoint]
"""
for i in range(n):
    chordNum = chords[i][1]
    if (chordNum in chord_map):
        chord_map[chordNum].append(angles[i])
    else:
        chord_map[chordNum] = [angles[i]]

for chord1 in chord_map.keys():
    for chord2 in chord_map.keys():
        # check if two chord intersect - (Say chord1, chord2)
        if (chord1 != chord2 and ( (chord1, chord2) not in chordPairSet or (chord2, chord1) not in chordPairSet) ):
            chordPairSet.add((chord1, chord2))
            chordPairSet.add((chord2, chord1))
            startAngle_chord1, endAngle_chord1 = chord_map[chord1]
            startAngle_chord2, endAngle_chord2 = chord_map[chord2]
            # condition 1 : start angle of chord2 must lie in between (start angle of chord1, end angle of chord1) 
            #               and the end angle of chord2 must NOT lie in the range (start angle of chord1, end angle of chord1) 
            condition1 = (startAngle_chord1 < startAngle_chord2 < endAngle_chord1) and not (startAngle_chord1 < endAngle_chord2 < endAngle_chord1)
            # condition 2 : end angle of chord2 must lie between (start angle of chord1, end angle of chord1) 
            #               and the start angle of chord2 must NOT lie in the range (start angle of chord1, end angle of chord1) 
            condition2 = (startAngle_chord1 < endAngle_chord2 < endAngle_chord1) and not (startAngle_chord1 < startAngle_chord2 < endAngle_chord1)
            # condition 3 : start angle of chord1 must lie in between (start angle of chord2, end angle of chord2) 
            #               and the end angle of chord1 must NOT lie in the range (start angle of chord2, end angle of chord2) 
            condition3 = (startAngle_chord2 < startAngle_chord1 < endAngle_chord2) and not (startAngle_chord2 < endAngle_chord1 < endAngle_chord2)
            # condition 4 : end angle of chord1 must lie between (start angel of chord2, end angle of chord2)
            #               and the start angle of chord1 must NOT lie in the range (start angle of chord2, end angle of chord2)
            condition4 = (startAngle_chord2 < endAngle_chord1 < endAngle_chord2) and not (startAngle_chord2 < startAngle_chord1 < endAngle_chord2)
            # if any ONE condition satisfies i.e., return true -> there is an INTERSECTION
            if (condition1 or condition2 or condition3 or condition4):
                num_intersections += 1

print(num_intersections)